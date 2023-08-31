import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { View2ShareNewsFormComponent } from './components/view2-share-news-form/view2-share-news-form.component';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import { View0TopTagsComponent } from './components/view0-top-tags/view0-top-tags.component';
import { View1ListNewsComponent } from './components/view1-list-news/view1-list-news.component'
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    View2ShareNewsFormComponent,
    View0TopTagsComponent,
    View1ListNewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
