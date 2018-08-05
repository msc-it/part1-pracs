%{
    Q. Histogram

Input parameters: NONE

An image histogram is drawn with intensity range [0, L-1] on x-axis and the
number (or probability for equalized histogram) of occurrence of a given
intensity on the y-axis.
%}

clc
close all

% Read sample image
img = imread('cameraman.tif');
[rows, cols] = size(img);

range = 0:255; % Intensity range over x-axis
val = zeros(1, 256); % Initialize values for intensity count over y-axis to 0

% Loop through image, and increment val
for x=1:rows
    for y=1:cols
        intensity = img(x,y);
        val(intensity) = val(intensity) + 1;
    end
end

% Show the original image
subplot(1, 2, 1);
imshow(img);
title('Original Image');

% Show the histogram
subplot(1, 2, 2);
stem(range, val);
title('Histogram');