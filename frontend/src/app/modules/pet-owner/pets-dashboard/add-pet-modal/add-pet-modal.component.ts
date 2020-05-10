import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SavePet} from "../../model/save-pet";
import {PetType} from "../../model/pet-type";

@Component({
  selector: 'app-add-pet-modal',
  templateUrl: './add-pet-modal.component.html',
  styleUrls: ['./add-pet-modal.component.scss']
})
export class AddPetModalComponent implements OnInit {

  addPetForm: FormGroup;
  base64Image: any;
  petTypes = PetType;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    //TODO form validation
    this.addPetForm = this.fb.group({
      name: ['', Validators.required],
      type: ['', Validators.required],
      dateOfBirth: ['', Validators.required],
    });
  }

  imageInputChange($event: any) {
    let reader = new FileReader();

    if ($event.target.files && $event.target.files.length) {
      const [file] = $event.target.files;
      reader.readAsDataURL(file);

      if (file.size > 5000000) {
        alert('Za duży rozmiar pliku (max 5MB)');
      } else {
        reader.onload = () => {
          this.base64Image = reader.result;
        };
      }
    }
  }

  onModalClose(isSubmitted: boolean) {
    return {
      isSubmitted: isSubmitted,
      pet: new SavePet(
        this.addPetForm.value.name,
        this.addPetForm.value.dateOfBirth,
        this.addPetForm.value.type,
        this.base64Image)
    }
  }
}
