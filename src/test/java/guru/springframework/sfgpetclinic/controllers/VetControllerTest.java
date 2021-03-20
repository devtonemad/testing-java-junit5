package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {
    SpecialityMapService specialityMapService;
    VetService vetService;
    VetController vetController;

    @BeforeEach
    public void setup() {
        specialityMapService = new SpecialityMapService();
        vetService = new VetMapService(specialityMapService);
        vetController = new VetController(vetService);

        Vet vet1 = new Vet(1L,"Banana", "Joe",null);
        Vet vet2 = new Vet(2L,"Apple", "Pi",null);

        vetService.save(vet1);
        vetService.save(vet2);

    }

    @Test
    public void testListVets(){
        Model model = new ModelMapImpl();
        assertEquals("vets/index",vetController.listVets(model));
        Set modellAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertEquals(2,(modellAttribute.size()));
    }

}