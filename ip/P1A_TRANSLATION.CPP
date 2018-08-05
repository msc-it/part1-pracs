#include <iostream.h>
#include <conio.h>
#include <graphics.h>

/*
Refer to P1A_SCALING.CPP for explanation
*/

void draw_rectangle(int r[4], const char* str)
{
	// Draw the rectangle
	rectangle(r[0], r[1], r[2], r[3]);
	// Add title text
	outtextxy(r[0], r[1] - 10, str);
}

int main()
{
	// Initialize graphics mode
	int gdriver = DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TURBOC3\\BGI");
	setcolor(15);

	// Declare variables
	int r[4], tr[4], tx, ty;

	cout << "Enter the coordinates: ";
	cin >> r[0] >> r[1] >> r[2] >> r[3];
	cout << "Enter the translation factor (tx, ty): ";
	cin >> tx >> ty;

	// Draw the original rectangle
	draw_rectangle(r, "Original figure");

	// Translate the rectangle
	tr[0] = r[0] + tx;
	tr[1] = r[1] + ty;
	tr[2] = r[2] + tx;
	tr[3] = r[3] + ty;

	// Draw the translated rectangle
	draw_rectangle(tr, "Translated figure");

	// Wait for keypress and exit graphics mode
	getch();
	closegraph();

	return 0;
}
