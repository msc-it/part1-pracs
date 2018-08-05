#include <iostream.h>
#include <graphics.h>
#include <conio.h>
#include <math.h>

/**
Rotates a point by angle in radians across origin (0,0)
and returns the x-component
 */
float rotx(int x, int y, float rot)
{
	return (x * cos(rot)) - (y * sin(rot));
}

/**
Rotates a point by angle in radians across origin (0,0)
and returns the y-component
 */
float roty(int x, int y, float rot)
{
	return (x * sin(rot)) + (y * cos(rot));
}

int main()
{
	// Initialize graphics mode
	int gdriver = DETECT, gmode;
	initgraph(&gdriver, &gmode, "C:\\TURBOC3\\BGI");

	// Declare variables
	int x1, y1, x2, y2; // Input line co-ordinates
	int x3, y3, x4, y4; // Output line co-ordinates
	float theta, rot;   // Angle in degrees and radians

	// Get the coordinates of the line and draw it
	cout << "Enter the value of (x1, y1) and (x2, y2): ";
	cin >> x1 >> y1 >> x2 >> y2;
	line(x1, y1, x2, y2);

	// Get the angle in degrees
	cout << "Enter the rotational angle: ";
	cin >> theta;

	// ... and convert it to radians
	rot = (theta/180) * 3.14;

	// Rotate the line
	// Use rotx for x-components and roty for y-components
	x3 = rotx(x1, y1, rot);
	y3 = roty(x1, y1, rot);
	x4 = rotx(x2, y2, rot);
	y4 = roty(x2, y2, rot);

	// Draw the rotated line
	line(x4, y4, x3, y3);

	// Wait for keypress & exit graphics mode
	getch();
	closegraph();

	return 0;
}