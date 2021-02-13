import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MapResultComponent } from './components/map-result/map-result.component';
import { MapResult2Component } from './components/map-result2/map-result2.component';
import { NewSearchComponent } from './components/new-search/new-search.component';

const routes: Routes = [
  {path:'new-search', component:NewSearchComponent},
  {path:'map-result/:id/:id2/:id3', component:MapResultComponent},
  {path:'map-result2', component:MapResult2Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
