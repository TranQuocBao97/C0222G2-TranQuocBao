export class Facility {
  id: number;
  name: string;
  imgUrl: string;
  area: number;


  constructor(id: number, name: string, imgUrl: string, area: number) {
    this.id = id;
    this.name = name;
    this.imgUrl = imgUrl;
    this.area = area;
  }
}
