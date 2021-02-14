export class Location {
    constructor(
        public name: string,
        public type: string,
        public address: string,
        public latitude: number,
        public longitude: number,
        public ratingsNum: number,
        public rating: number,
        public openNow: boolean
      ){}
}