export class SavePet {
  constructor(public name: string,
              public dateOfBirth: Date,
              public type: string,
              public base64Image?: File) {
  }
}
