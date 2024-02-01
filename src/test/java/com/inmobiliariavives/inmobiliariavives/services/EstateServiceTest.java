package com.inmobiliariavives.inmobiliariavives.services;
import com.inmobiliariavives.inmobiliariavives.dto.EstateGetDTO;
import com.inmobiliariavives.inmobiliariavives.models.EstateEntity;
import com.inmobiliariavives.inmobiliariavives.models.MasterEntity;
import com.inmobiliariavives.inmobiliariavives.models.UserEntity;
import com.inmobiliariavives.inmobiliariavives.repositories.EstateRepository;
import com.inmobiliariavives.inmobiliariavives.repositories.MasterRepository;
import com.inmobiliariavives.inmobiliariavives.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class EstateServiceTest {
    @Autowired
    private EstateService estateService;

    @MockBean
    private EstateRepository estateRepository;

    @MockBean
    private MasterRepository masterRepository;

    @MockBean
    private UserRepository userRepository;


    // Creates a Mock Entity
    private EstateEntity createMockEstateEntity(
            String title, String description, Double price,
            Integer bedrooms, Integer bathrooms, Integer area,
            UserEntity user, MasterEntity modality, String department,
            String province, String district, Double estateLng,
            Double estateLat, UUID creationUser, Integer state
    ){
        EstateEntity estateEntity = new EstateEntity();
        estateEntity.setTitle(title);
        estateEntity.setDescription(description);
        estateEntity.setPrice(price);
        estateEntity.setBedrooms(bedrooms);
        estateEntity.setBathrooms(bathrooms);
        estateEntity.setArea(area);
        estateEntity.setUser(user);
        estateEntity.setModality(modality);
        estateEntity.setDepartment(department);
        estateEntity.setProvince(province);
        estateEntity.setDistrict(district);
        estateEntity.setEstateLng(estateLng);
        estateEntity.setEstateLat(estateLat);
        estateEntity.setCreationUser(creationUser);
        estateEntity.setState(state);

        return estateEntity;
    }

    @Test
    public void testFindAll() {

        UserEntity mockUser = new UserEntity();
        MasterEntity mockModality = new MasterEntity(); // Modality mock

        // Configures the behavior of the mock repository
        when(estateRepository.findByState(1)).thenReturn(Arrays.asList(
                createMockEstateEntity("Property 1", "Description 1", 100000.0, 3, 2, 150, mockUser, mockModality,
                        "Department 1", "Province 1", "District 1", -77.0369, 38.9072,
                                    UUID.randomUUID(), 1),
                createMockEstateEntity("Property 2", "Description 2", 150000.0, 4, 3, 200, mockUser, mockModality,
                             "Department 2", "Province 2", "District 2", -74.006, 40.7128,
                                          UUID.randomUUID(), 1)
        ));

        // Calls the methos and verify the result
        List<EstateGetDTO> result = estateService.findAll();

        // Verifies the expected result
        assertEquals(2, result.size());
        assertEquals("Property 1", result.get(0).getTitle());
        assertEquals("Property 2", result.get(1).getTitle());

        // Verifies that repository methods are called correctly
        verify(estateRepository, times(1)).findByState(1);
    }

    @Test
    public void testFindByIdEntityExists() {
        // Test date
        UUID entityId = UUID.randomUUID();
        EstateEntity mockEntity = createMockEstateEntity(entityId);
        EstateGetDTO expectedDto = createMockEstateGetDTO(entityId);

        // Configures simulated repository behavior
        when(estateRepository.findById(entityId)).thenReturn(Optional.of(mockEntity));

        // Calls the method under test
        EstateGetDTO resultDto = estateService.findById(entityId);

        // Verifies the DTO of the result
        assertNotNull(resultDto);
        assertEquals(expectedDto.getId(), resultDto.getId());

    }

    @Test
    public void testFindByIdEntityNotFound() {

        // Test data
        UUID nonExistentEntityId = UUID.randomUUID();

        // Configures simulated repository behavior
        when(estateRepository.findById(nonExistentEntityId)).thenReturn(Optional.empty());

        // Calls the method under test
        EstateGetDTO resultDto = estateService.findById(nonExistentEntityId);

        // Verifies the result
        assertNull(resultDto);
    }

    // Helper method to create a mock entity
    private EstateEntity createMockEstateEntity(UUID id) {

        EstateEntity estateEntity = new EstateEntity();
        estateEntity.setId(id);
        estateEntity.setTitle("title");
        estateEntity.setDepartment("department");
        estateEntity.setProvince("province");
        estateEntity.setDistrict("district");
        return estateEntity;
    }

    // Helper method to create a simulated DTO
    private EstateGetDTO createMockEstateGetDTO(UUID id) {

        EstateGetDTO estateGetDTO = new EstateGetDTO();
        estateGetDTO.setId(id);
        return estateGetDTO;

    }



}
