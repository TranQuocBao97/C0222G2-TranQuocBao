export class Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  customer?: any;
  employee?: any;
  facility?: any;
  contractOtherServices?: any;

  constructor(id: number, startDate: string, endDate: string, customer: any, employee: any, facility: any, contractOtherServices: any) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.customer = customer;
    this.employee = employee;
    this.facility = facility;
    this.contractOtherServices = contractOtherServices;
  }
}
