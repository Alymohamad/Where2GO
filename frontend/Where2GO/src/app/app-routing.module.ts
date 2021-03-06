import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MapResultComponent } from './components/map-result/map-result.component';
import { NewSearchComponent } from './components/new-search/new-search.component';

const routes: Routes = [
  {path:'', component:NewSearchComponent},
  {path:'new-search', component:NewSearchComponent},
  {path:'map-result', component:MapResultComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
