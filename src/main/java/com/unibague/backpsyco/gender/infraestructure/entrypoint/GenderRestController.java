package com.unibague.backpsyco.gender.infraestructure.entrypoint;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.gender.domain.usecase.GenderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genders")
@RequiredArgsConstructor
public class GenderRestController {

    private final GenderUseCase genderUseCase;

    @GetMapping
    public ResponseEntity<List<Gender>> getAllGenders() {
        List<Gender> genders = genderUseCase.getAllGenders();
        return ResponseEntity.ok(genders);
    }

}
