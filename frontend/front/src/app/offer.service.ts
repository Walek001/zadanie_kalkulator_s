import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable({providedIn: 'root'})
export class OfferService {
  private url = 'http://localhost:8080/api/offers';


  constructor(private http: HttpClient) { }

  calcOffer(dailyPayment: number, countryID: number) {
    console.log(dailyPayment, countryID)
    const body = "?country=" + countryID + "&dailyPayment=" + dailyPayment * 100;
    console.log(this.url+body);
    return this.http.post(this.url+body, "");
  }
}
