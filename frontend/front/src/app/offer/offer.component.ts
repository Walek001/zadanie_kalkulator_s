import {Component, OnInit} from '@angular/core';
import {Offer} from "../offer";
import {Country} from "../country";
import {CountryService} from "../country.service";
import {OfferService} from "../offer.service";
import {OfferDto} from "../offer.dto";

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {
  offer: Offer = {
    countryId: 1,
    dailyPayment: 100
  };

  countries:Country[] = [];
  selectedOption: any = 1;
  offerDTO: OfferDto;

  constructor(private countryService: CountryService,
              private offerService: OfferService) {
  };

  ngOnInit() {
    this.getCountries();
  }

  getCountries() {
    this.countryService.getCountries().subscribe(data => {
        for (const d of (data as any)) {
          console.log(d)
          this.countries.push({
            isoCode: d.isoCode,
            id: d.id
          })
        }
      console.log(this.countries)
      }
    );
  };

  calcOffer(dailyPayment: number, countryID: number) {
    this.offerService.calcOffer(dailyPayment, countryID).subscribe(data => {
        this.offerDTO = new OfferDto(data["monthPayment"], data["countryCode"]);
        console.log(this.offer);
    });
  }

}
