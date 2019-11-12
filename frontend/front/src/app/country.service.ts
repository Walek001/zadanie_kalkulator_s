import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable({providedIn: 'root'})
export class CountryService {
  private url = 'http://localhost:8080/api/countries';


  constructor(private http: HttpClient) { }

  getCountries() {
    return this.http.get(this.url)
  }
}
