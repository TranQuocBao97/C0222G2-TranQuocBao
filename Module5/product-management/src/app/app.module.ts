import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SharedModule} from './shared/shared.module';
import {HttpClientModule} from '@angular/common/http';
import {PagingComponent} from './paging/paging.component';

@NgModule({
  declarations: [
    AppComponent,
    PagingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    HttpClientModule
  ],
  providers: [],
  exports: [
    PagingComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
