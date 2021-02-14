import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchResponse } from 'src/app/models/SearchResponse';
import { SearchService } from 'src/app/services/search.service';
import { HttpParams } from '@angular/common/http';



export class User {
  public city: string;
  public filter: string;
}
@Component({
  selector: 'app-new-search',
  templateUrl: './new-search.component.html',
  styleUrls: ['./new-search.component.css'],
})
export class NewSearchComponent implements OnInit {

  private searchResponse: SearchResponse;
  private searchService: SearchService;
  public location: Location;


  constructor(private router: Router, searchService: SearchService) {
    this.searchService = searchService;
  }
  //Send Data to map-result

  //Used to show the radius size
  gridsize: number = 50;
  updateSetting(event) {
    this.gridsize = event.value;
  }

  ngOnInit(): void {

    //console.log(this.searchResponse.location)
    //console.log(this.searchResponse.status)

  }

  onSubmit(form) {
    let radius:number;
    console.log(form.value.name)
    console.log(form.value.filter.name)
    console.log(this.gridsize)
    const params = new HttpParams()
    .set('city', form.value.name)
    .set('type', String(form.value.filter))
    .set('radius', String(this.gridsize));

      this.searchService.getRandomLocation(params).then((result) => {
        console.log("--------")
        this.searchResponse = result
        console.log(this.searchResponse)
        console.log("++++++++")

        if(String(this.searchResponse.status) === "SUCCESSFULL"){
          this.searchService.setLocation(this.searchResponse.location);
          this.router.navigate(['/map-result'], {queryParams: {city:form.value.name}});
          //{queryParams: {city:form.value.name}}
        } else {
          //Error handling
        }

      });
      
    console.log(form.value.name)
    console.log(this.selectedFilter)
    console.log(this.gridsize)
    console.log("kkkkkkkkkkkk")
    console.log(this.searchResponse.location)
    if(String(this.searchResponse.status) === "SUCCESSFULL"){
      this.router.navigate(['/map-result']);
      //{queryParams: {city:form.value.name}}
    } else {
      //Error handling
    }
    //this.router.navigate(['/map-result', 'Wien', 'Restaurant', '50']);

  }

  //Used for the dropdown menu of the filters
  model = new User();
  selectedFilter: string;
  Filter: string[] = [
    'Restaurant',
    'Museum',
    'Park',
    'Cinema',
    'Church',
    'Football',
    'Tennis',
    'Golf',
    'Handball',
    'Opera',
    'Theater',
    'Synagogue',
    'Mosque',
    'Swimming',
    'Gym',
    'Leisure Activity',
    'Climbing',
    'Hiking',
    'Running',
    'Dancing',
    'Bike'

  ];
}
