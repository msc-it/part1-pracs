%{
    Q. High pass filter

Input parameters:
    - mask

%}

clc
close all

% Read sample image
img = imread('kids.tif');
[rows, cols] = size(img);

p = double(img);

% Initialize mask/window, w, or get from the user
w = [-1 -1 -1;
     -1  8 -1;
     -1 -1 -1];

% Initialize output image matrix with 
output = p;

for x = 2:1:row-1
    for y = 2:1:col-1 
        output(x,y) = w(1) * p(x-1, y-1) + w(2) * p(x, y-1) + w(3) * p(x+1, y-1) ...
                    + w(4) * p(x-1, y)   + w(5) * p(x, y)   + w(6) * p(x+1, y) ...
                    + w(7) * p(x-1, y+1) + w(8) * p(x, y+1) + w(9) * p(x+1, y+1);
    end
end

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the negative image
subplot(1, 2, 2);
imshow(uint8(output));
title('High pass filtered image');