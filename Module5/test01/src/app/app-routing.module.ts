import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ArticleComponent} from './ss04/article/article.component';
import {AngularColorPickerAppComponent} from './angular-color-picker-app/angular-color-picker-app.component';


const routes: Routes = [
  {path: 'article', component: ArticleComponent},
  {path: 'color', component: AngularColorPickerAppComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
