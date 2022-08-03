import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FacilityRoutingModule} from './facility-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {FacilityAddComponent} from './facility-add/facility-add.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';
import {AngularFireModule} from '@angular/fire';





const firebaseConfig = {
  apiKey: 'AIzaSyBuaZrT7AQMbd4EmN65Xi0H8Fx-ZM2nuOg',
  authDomain: 'module5-a3244.firebaseapp.com',
  projectId: 'module5-a3244',
  storageBucket: 'module5-a3244.appspot.com',
  messagingSenderId: '63191704147',
  appId: '1:63191704147:web:62e078265b41ed0d9f5ca6',
  measurementId: 'G-7Y2BDQ7WZ1'
};

@NgModule({
  declarations: [
    FacilityListComponent,
    FacilityAddComponent,
    FacilityEditComponent
  ],
  imports: [
    CommonModule,
    FacilityRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    AngularFireModule.initializeApp(firebaseConfig)
  ]
})
export class FacilityModule {
}
