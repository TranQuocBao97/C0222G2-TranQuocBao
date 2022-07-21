export class Employee {
  id: number;
  name: string;
  dateOfBirth: string;
  address: string;


  constructor(id: number, name: string, dateOfBirth: string, address: string) {
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
  }
}
