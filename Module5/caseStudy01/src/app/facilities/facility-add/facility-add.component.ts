import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {formatDate} from '@angular/common';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import { FacilityService } from 'src/app/services/facility.service';


@Component({
  selector: 'app-facility-add',
  templateUrl: './facility-add.component.html',
  styleUrls: ['./facility-add.component.css']
})
export class FacilityAddComponent implements OnInit {
  facilityForm: FormGroup;
  selectImg: any;
  buttonDisabled: boolean = false;

  constructor(private storage: AngularFireStorage,
              private router: Router,
              private mess: ToastrService,
              private facilityService: FacilityService) {
  }

  ngOnInit(): void {
    this.getFacilityForm();
  }

  getFacilityForm() {
    this.facilityForm = new FormGroup({
      imgUrl: new FormControl(''),
      name: new FormControl('', [Validators.required, Validators.pattern('^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$')]),
      area: new FormControl('', [Validators.required]),
      cost: new FormControl('', [Validators.required, Validators.min(100000)]),
      facilityType: new FormControl({id: 1, name: 'Room'}, [Validators.required]),
      rentType: new FormControl({id: 1, name: 'Thuê theo ngày'}, [Validators.required])
    });
  }

  showPicture(event: any) {
    this.selectImg = event.target.files[0];
  }

  addNewFacility() {
    console.log(this.facilityForm.value);
    const nameImg = this.getCurrentDateTime() + this.selectImg.name;
    const fileRef = this.storage.ref(nameImg);
    this.storage.upload(nameImg, this.selectImg).snapshotChanges().pipe(finalize(() => {
      this.buttonDisabled = true;
      fileRef.getDownloadURL().subscribe((url) => {
        this.facilityForm.patchValue({imgUrl : url});
        console.log(this.facilityForm.value.imgUrl);
        // Call API to create
        this.facilityService.addFacility(this.facilityForm.value).subscribe(data => {

        }, error => {
          this.buttonDisabled = false;
            console.log(error);
          this.mess.warning('Thất bại', 'Thêm mới');
        }, () => {
          this.router.navigate(['facility/list']);
          this.mess.success('Thành công', 'Thêm mới');
        })

      });
      })
    ).subscribe(data =>{

    }, error => {
    });
  }



  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyy-hh:mm:ssa', 'en-US');
  }

}
