INSERT INTO public.currency (id, currency_code, exchange_rate, last_update) VALUES (2, 'EUR', 2, null);
INSERT INTO public.currency (id, currency_code, exchange_rate, last_update) VALUES (3, 'GBP', 3, null);
INSERT INTO public.currency (id, currency_code, exchange_rate, last_update) VALUES (1, 'PLN', 1, null);

INSERT INTO public.country (id, fixed_costs, iso_code, tax, currency_id) VALUES (3, 600, 'GB', 25, 3);
INSERT INTO public.country (id, fixed_costs, iso_code, tax, currency_id) VALUES (2, 800, 'DE', 20, 2);
INSERT INTO public.country (id, fixed_costs, iso_code, tax, currency_id) VALUES (1, 1200, 'PL', 19, 1);