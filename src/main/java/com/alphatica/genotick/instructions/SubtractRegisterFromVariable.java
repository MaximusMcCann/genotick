package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class SubtractRegisterFromVariable extends RegVarInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -2540080410599300603L;

    private SubtractRegisterFromVariable(SubtractRegisterFromVariable i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public SubtractRegisterFromVariable() {
    }

    @Override
    public void executeOn(Processor processor) {
        processor.execute(this);
    }

    @Override
    public SubtractRegisterFromVariable copy() {
        return new SubtractRegisterFromVariable(this);
    }
}
