#include <iostream.h>
#include <graphics.h>
#include <conio.h>
#include <math.h>

int main()
{
	// Initialize graphics mode
	int gd = DETECT, gm;
	initgraph(&gd, &gm, "C:\\TURBOC3\\BGI");

	int x, y, x1, y1, x2, y2;
	float dx, dy, e;
	int i = 1;

	cout << "Enter (x, y), (x', y'): ";
	cin >> x1 >> y1 >> x2 >> y2;

	dx = abs(x2 - x1);
	dy = abs(y2 - y1);
	x = x1;
	y = y1;
	e = 2 * dy - dx;

	do
	{
		putpixel(x, y, 15);
		while(e >= 0)
		{
			y++;
			e = e - 2 * dx;
		}
		x++;
		e = e + 2 * dy;
		i++;
	} while(i <= dx);

	// Wait for keypress and quit graphics mode
	getch();
	closegraph();

	return 0;
}