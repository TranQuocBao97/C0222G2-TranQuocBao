import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ArticleComponent} from './ss04/article/article.component';
import {AngularColorPickerAppComponent} from './angular-color-picker-app/angular-color-picker-app.component';
import {TimelinesComponent} from './timelines/timelines.component';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-player/youtube-player.component';
import {ProductListComponent} from './product-manager/product/product-list/product-list.component';
import {ProductCreateComponent} from './product-manager/product/product-create/product-create.component';
import {DictionayPageComponent} from './ss07-dictionary/dictionay-page/dictionay-page.component';
import {DictionaryDetailComponent} from './ss07-dictionary/dictionary-detail/dictionary-detail.component';
import {ProductUpdateComponent} from './product-manager/product/product-update/product-update.component';


const routes: Routes = [
  {path: 'article', component: ArticleComponent},
  {path: 'color', component: AngularColorPickerAppComponent},
  {path: 'timelines', component: TimelinesComponent},
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
      path: ':id',
      component: YoutubePlayerComponent
    }]
  },
  {
    path: 'product/list',
    component: ProductListComponent
  }, {
    path: 'product/create',
    component: ProductCreateComponent
  },
  {
    path: 'product/edit/:id',
    component: ProductUpdateComponent
  },
  {
    path: 'dictionary/list',
    component: DictionayPageComponent
  },
  {
    path: 'dictionary/detail/:word',
    component: DictionaryDetailComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
