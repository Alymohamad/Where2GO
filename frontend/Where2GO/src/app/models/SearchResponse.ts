import { Location } from "./Location";

export class SearchResponse {
    constructor(
        public location: Location,
        public status: string
      ){}
}