%{
    Q. Demonstrate gray level slicing (image enhancement technique)

Input parameters:
    - Lower Limit (a)
    - Upper limit (b)
    - High value  (h, usually white i.e. 255)
    - Low value   (l, usually black i.e. 0)

Gray level slicing has two approaches:

1. Without Background: Display high value for intensities in range of [a, b]
and low value for all other gray levels
2. With Background: Display high vlalue for intensities in range of [a, b]
and leave the rest as it is.
%}

clc
close all

% Read sample image
img = imread('cameraman.tif');
[row, col] = size(img);

% Assign the input parameters
a = 100;
b = 150;
h = 255;
l = 0;

%%% Approach 1 - Without background

% Create output image matrix initialized with l
output1 = ones(x, y) * l;

% Loop through every pixel of the input image
for x = 1:1:row
    for y = 1:1:col
        % If the current pixel is in range [a, b]
        % set the pixel to h
        if img(x,y) >= a && img(x,y) <= b
            output1(x,y) = h;
        end
    end
end

%%% Approach 2 - With background
%%% Same as 1, only difference in initialization

% Create output image matrix with same values as input image
output2 = img;

% Loop through every pixel of the input image
for x = 1:1:row
    for y = 1:1:col
        % If the current pixel is in range [a, b]
        % set the pixel to h
        if img(x,y) >= a && img(x,y) <= b
            output2(x,y) = h;
        end
    end
end

% Show the original image
subplot(1, 3, 1);
imshow(img);
title('Original Image');

% Show the output images
subplot(1, 3, 2);
imshow(output1);
title('Approach 1 - w/o background');
subplot(1, 3, 3);
imshow(output2);
title('Approach 2 - w/ background');