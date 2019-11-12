export class OfferDto {
  monthPayment: number;
  countryCode: string;

  constructor(monthPayment: number, countryCode: string) {
    this.monthPayment = monthPayment;
    this.countryCode = countryCode;
  }
}
