import {CustomerType} from './CustomerType';

export interface Customer {
  id?: number;
  name?: string;
  dateOfBirth?: string;
  address?: string;
  idCard?: string;
  email?: string;
  gender?: any;
  customerType?: CustomerType;

}
