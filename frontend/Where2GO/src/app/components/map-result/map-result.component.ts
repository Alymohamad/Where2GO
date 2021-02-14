import { Component, Input} from '@angular/core';
import { Location } from 'src/app/models/Location';
import { SearchService } from 'src/app/services/search.service';


@Component({
  selector: 'app-map-result',
  templateUrl: './map-result.component.html',
  styleUrls: ['./map-result.component.css']
})
export class MapResultComponent  {

  private searchService: SearchService;
  public location: Location;

  public lat: number;
  public lng: number;
  public title: String;


  constructor(searchService: SearchService) {
    this.searchService = searchService;
    this.location = searchService.getLocation();
    console.log("I AM HEEEEEREEEE " + this.location.latitude)
    console.log("I AM HEEEEEREEEE " + this.location.longitude)
    console.log("I AM HEEEEEREEEE " + this.location.name)
    this.lat = this.location.latitude
    this.lng = this.location.longitude
    this.title = this.location.name


  }
}