import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchService } from 'src/app/services/search.service';


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

  public response: Response;
  public searchService: SearchService

  constructor(private router: Router,  searchService: SearchService) {
    this.searchService = searchService;
   }
  //Send Data to map-result

  //Used to show the radius size
  gridsize: number = 50;
  updateSetting(event) {
    this.gridsize = event.value;
  }

  ngOnInit(): void {

    this.searchService.getRandomLocation().subscribe(
      res => {
        if (!res) {
          console.log(Error)
        } else {
          console.log(res)
        }
      })
  }

  onSubmit(form) {
    console.log(form.value)
    this.router.navigate(['/map-result', 'Wien', 'Restaurant', '50']);
  }

  //Used for the dropdown menu of the filters
  model = new User();
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
