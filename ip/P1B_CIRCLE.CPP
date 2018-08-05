#include <iostream.h>
#include <math.h>
#include <conio.h>
#include <graphics.h>

int main()
{
	// Initialize graphics mode
	int gd = DETECT, gm;
	initgraph(&gd, &gm, "C:\\TURBOC3\\BGI");

	// Declare variables
	int x, y, r; // radius & temporary x, y values
	int xm = 200, ym = 200; // Midpoint of circle
	float d; // decision variable

	// Get midpoint and radius from user
	cout << "Enter midpoint (x,y): ";
	cin >> xm >> ym;
	cout << "Enter the radius: ";
	cin >> r;

	// Initialize variables as per algorithm
	x = 0;
	y = r;
	d = 3 - 2 * r;

	do
	{
		// Draw the 8 pixels
		putpixel(xm + x, ym + y, 15); // 15 is for WHITE
		putpixel(xm + x, ym - y, 15);
		putpixel(xm - x, ym + y, 15);
		putpixel(xm - x, ym - y, 15);
		putpixel(xm + y, ym + x, 15);
		putpixel(xm + y, ym - x, 15);
		putpixel(xm - y, ym + x, 15);
		putpixel(xm - y, ym - x, 15);

		// Update variables as per algorithm
		if(d <= 0)
		{
			d = d + 4 * x + 6;
		}
		else
		{
			d = d + 4 * (x - y) + 10;
			y--;
		}
		x++;
	} while(x <= y);

	// Wait for keypress and quit graphics mode
	getch();
	closegraph();

	return 0;
}