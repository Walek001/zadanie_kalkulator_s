1. Utils package contains interface for currencies exchange, because we use it in future we can easly imnplement new Api.
2. Offer saves daily rate, because in future we can calculate salary per week or per working days in specified month/year.
3. Country has relation to offers, because if we delete the country we want to delete all of the offers which are in this country.
4. Offer has PERSIST relation to country, because we want to update country every time we update offer. 
5. Frontend app is in frontend folder. 
6. I do not make test for simple crud operations, focusing more on business logic.
7. I don't test fronted, because I don't have previous experience with Angular or any Frontend framework, if I have more time I probably try to use Selenium for behavioral testing. 