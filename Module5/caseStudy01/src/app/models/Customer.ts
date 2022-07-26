export class Customer {
  id: number;
  name: string;
  address: string;
  idCard: string;
  email: string;


  constructor(id: number, name: string, address: string, idCard: string, email: string) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.idCard = idCard;
    this.email = email;
  }
}
