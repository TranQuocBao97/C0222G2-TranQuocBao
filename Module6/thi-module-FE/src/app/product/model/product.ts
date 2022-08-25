export interface Product {
  id: number;
  code: string;
  name: string;
  price: number;
  company: string;
  dateCreateProduct: string;
  isGas: boolean;
  cakeSugar: boolean;
  writer: string;
  bookType: string;
  dateCreateBook: string;
  status: boolean;
  isDeleted: boolean;
  productType: any;
  productOrders: any;
}
