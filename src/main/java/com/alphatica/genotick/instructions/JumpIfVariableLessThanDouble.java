package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfVariableLessThanDouble extends VarDoubleJumpInstruction{
    @SuppressWarnings("unused")
    private static final long serialVersionUID = -8449905052813057724L;

    private JumpIfVariableLessThanDouble(JumpIfVariableLessThanDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfVariableLessThanDouble() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfVariableLessThanDouble copy() {
        return new JumpIfVariableLessThanDouble(this);
    }
}
