import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';


const routes: Routes = [
  // {path: '', component: HomePageComponent},
  {path: 'contract', loadChildren: () => import('./contract/contract.module').then(module => module.ContractModule)},
  {path: 'customer', loadChildren: () => import('./facilities/facility.module').then(module => module.FacilityModule)},
  {path: 'facilities', loadChildren: () => import('./customer/customer.module').then(module => module.CustomerModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
