import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Pet} from "../../model/pet";

@Component({
  selector: 'app-add-pet-modal',
  templateUrl: './add-pet-modal.component.html',
  styleUrls: ['./add-pet-modal.component.scss']
})
export class AddPetModalComponent implements OnInit {

  addPetForm: FormGroup;
  imageFile: File;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    //TODO form validation
    this.addPetForm = this.fb.group({
      name: ['', Validators.required],
      yearOfBirth: ['', Validators.required],
    });
  }

  imageInputChange(imageInput: HTMLInputElement) {
    this.imageFile = imageInput.files[0];
  }

  onModalClose(isSubmitted: boolean) {
    return {
      isSubmitted: isSubmitted,
      pet: new Pet("fd488ff8-1718-47c2-900a-67eef6606d4f",
        this.addPetForm.value.name, this.addPetForm.value.yearOfBirth, this.imageFile)
    }
  }
}
