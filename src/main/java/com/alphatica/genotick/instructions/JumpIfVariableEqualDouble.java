package com.alphatica.genotick.instructions;

import com.alphatica.genotick.processor.Processor;

public class JumpIfVariableEqualDouble extends VarDoubleJumpInstruction {
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 3937406272874353714L;

    private JumpIfVariableEqualDouble(JumpIfVariableEqualDouble i) {
        super(i);
    }

    @SuppressWarnings("unused")
    public JumpIfVariableEqualDouble() {
    }

    @Override
    public void executeOn(Processor processor)  {
        processor.execute(this);
    }

    @Override
    public JumpIfVariableEqualDouble copy() {
        return new JumpIfVariableEqualDouble(this);
    }
}
