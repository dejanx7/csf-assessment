import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { View0TopTagsComponent } from './components/view0-top-tags/view0-top-tags.component';
import { View2ShareNewsFormComponent } from './components/view2-share-news-form/view2-share-news-form.component';
import { View1ListNewsComponent } from './components/view1-list-news/view1-list-news.component';

const routes: Routes = [
  {path: '', component: View0TopTagsComponent, title: "Top Tags"},
  {path: 'postnews', component: View2ShareNewsFormComponent, title: "Share a News"},
  {path: 'listnews', component: View1ListNewsComponent, title: "List of News"},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
