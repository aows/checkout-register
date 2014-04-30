checkout-register
=================

This project implements a basic register.

## how to run it

Set the catalog up in catalog.csv. Example:

    A,Product A,20
	B,Product B,50
	C,Product C,30

Open input.csv and type all the products the cashier will register. This version only supports products with a single char code. Example:

	ABBACBBAB

Run the Main class and you'll get the results as follows:

	A - Product A		$20.0
	B - Product B		$50.0
	B - Product B		$50.0
	A - Product A		$20.0
	C - Product C		$30.0
	B - Product B		$50.0
	B - Product B		$50.0
	A - Product A		$20.0
	B - Product B		$50.0
	----------------
	subtotal		$340.0
	----------------
	Get 5 for 3
	Product B		-$100.0
	
	----------------
	total		$240.0
	----------------
	
	THANKS FOR YOUR VISIT
