%{
Q. Hidden Markov Model
    A. Generate a test sequence
    B. Generate a random sequence of step and emissions from the model
    C. Estimate State sequence
    D. Test the accuracy of HMM viterbi codes, compute the percentage of
the actual sequence states that agrees with the sequence likely states
    E. Estimate posterior state probabilities
%}

% disp() with last large sequences have been commented out for cleaner
% output

% Transition matrix of the HMM
TRANS = [ 
	.9  .1; 
    .05 .95
];
disp 'TRANSITION MATRIX'
disp(TRANS)

%Emission Matrix
EMIS = [
    1/6  1/6  1/6  1/6  1/6  1/6;
    7/12 1/12 1/12 1/12 1/12 1/12
];
disp 'EMISSION MATRIX'
disp(EMIS)

% A, B. Generate random sequence of emission symbols and states
[seq, states] = hmmgenerate(1000, TRANS, EMIS); % Generate 1000 values

% C. Estimate likely states
likelystates = hmmviterbi(seq, TRANS, EMIS);
% disp 'LIKELY STATES'
% disp(likelystates)

% D. Test accuracy of the likely states
% Accuracy = (no of instances where likely states == actual states) / (total no of states)
accuracy = sum(states==likelystates) / 1000;
disp 'ACCURACY %'
disp(accuracy*100)

% E. Posterior state probability
[TRANS_EST, EMIS_EST] = hmmestimate(seq, states);
pstates = hmmdecode(seq, TRANS, EMIS);
% disp 'POSTERIOR STATE PROBABILITY'
% disp(pstates)