%{
    Q. Write program to generate basic signals
    Reference: http://dsp.cs.cmu.edu/notes/intro_to_signals/signals.html
%}

clc;
close all;
n = 5; % An arbitrary constant

%{
    Unit impulse signal
    0 everywhere, 1 *only* at origin
%}
x = -n:1:n; % Array of numbers from -2 to 2 with interval of 1
y = [zeros(1,n),ones(1),zeros(1,n)]; % zeros(x,y) returns x-dimension array of y elements
% Draw the graph
subplot(3,2,1); % Split the window into a 3x2 grid, and select the 1st position
stem(x,y); % Use plot() for continuous
ylabel('Amplitude---->'); % Set x-axis label
xlabel('n---->'); % Set y-axis label
title('Unit Impulse Signal'); % Set graph title

%{
    Unit step signal
    0 everywhere, 1 *from* origin onwards
%}
t = -n:1:n-1;
y = [zeros(1,n), ones(1,n)];
% Draw the graph
subplot(3, 2, 2);
stem(t, y);
ylabel('Amplitude---->');
xlabel('n---->');
title('Unit Step Signal');

%{
    Ramp signal
    Increase from 0 to n by a constant
%}
t = 0:1:n;
subplot(3, 2, 3);
% Draw the graph
stem(t, t);
ylabel('Amplitude-------->');
xlabel('n---->');
title('Ramp Sequence');

%{
    Exponential signal (general form, y = e^αt)
    Adjust α to get the desired exponential curve
    Use -ve value for α for decreasing curve
%}
t = 0:1:40;
y = exp(.2 * t); % Here α is 0.2
% Draw the graph
subplot(3, 2, 4);
stem(t, y);
ylabel('Amplitude-------->');
xlabel('n---->');
title('Exponential Sequence');

%{
    Sine wave
%}
t = 0:.05:n; % Using an interval of 0.05 for a more pronounced sinusoidal
y = sin(4 * t); % Multiplying by constant (4) to get more cycles
% Draw the graph
subplot(3, 2, 5);
stem(t, y);
ylabel('Amplitude-------->');
xlabel('n---->');
title('Sine Sequence');

%{
    Cosine wave
%}
t = 0:.05:n;
y = cos(4 * t);
% Draw the graph
subplot(3, 2, 6);
stem(t, y);
ylabel('Amplitude-------->');
xlabel('n---->');
title('Cosine Sequence');
