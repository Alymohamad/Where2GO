import { Component } from '@angular/core';
import { Router } from '@angular/router';


export class User {
  public city: string;
  public email: string;
  public password: string;
  public filter: string;
}
@Component({
  selector: 'app-new-search',
  templateUrl: './new-search.component.html',
  styleUrls: ['./new-search.component.css'],
})
export class NewSearchComponent {
  
  //Send Data to map-result

  //Used to show the radius size
  gridsize: number = 50;
  updateSetting(event) {
    this.gridsize = event.value;
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

constructor(private router: Router) { }

  onSubmit(form) {
    
    console.log(form.value)
    this.router.navigate(['/map-result', 'Wien', 'Restaurant', '50']);
  }
}
