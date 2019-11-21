import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({providedIn: 'root'})
export class OfferService {
  private url = 'http://localhost:8080/api/offers';


  constructor(private http: HttpClient) { }

  calcOffer(dailyPayment: number, countryID: number) {
    console.log(dailyPayment, countryID);
    dailyPayment = dailyPayment * 100;
    let dailyPaymentString = dailyPayment.toFixed(0);
    const params = "?country=" + countryID ;
    let header = new HttpHeaders({'content-type': 'application/json'});
    return this.http.post(this.url+params, "{\"dailyPayment\": "+ dailyPaymentString +"}", {headers: header});
  }
}
