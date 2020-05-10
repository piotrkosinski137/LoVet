export class Pet {
  constructor(public id: string,
              public name: string,
              public type: string,
              public dateOfBirth: Date,
              public photoUrl?: string) {
  }
}
