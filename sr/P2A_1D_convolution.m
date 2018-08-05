%{
    Q. Write program to perform 1D linear convolution
%}

clc;
close all;

x = ones(1,5); % input is a 1D array
h = 1:8;       % impulse signal
y = conv(x,h); % Calculating convolution of x and h

% Plot the input signal
subplot(3,1,1);
stem(x);
ylabel('Amplitude--->');
xlabel('n----->');
title('Input sequence');

% Plot the impulse signal
subplot(3,1,2);
stem(h);
xlabel('n---->');
ylabel('Amplitude--->');
title('Impulse Response--->');

% Plot the convoluted output signal
subplot(3,1,3);
stem(y);
xlabel('n--->');
ylabel('Amplitude--->');
title('Convoluted Output Sequence');
