package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class NaturalLogarithmOfRegister extends RegRegInstruction implements MathInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -5965927479237202603L;

    private NaturalLogarithmOfRegister(NaturalLogarithmOfRegister i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public NaturalLogarithmOfRegister() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public NaturalLogarithmOfRegister copy() {
        return new NaturalLogarithmOfRegister(this);
    }
}
