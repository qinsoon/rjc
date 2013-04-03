package org.mmtk.policy;

/**
 * Interface to use to implement the Visitor Pattern for Spaces.
 */
public interface SpaceVisitor {
  void visit(Space s);
}
