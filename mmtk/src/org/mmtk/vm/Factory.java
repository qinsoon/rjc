/*
 *  This file is part of the Jikes RVM project (http://jikesrvm.org).
 *
 *  This file is licensed to You under the Eclipse Public License (EPL);
 *  You may not use this file except in compliance with the License. You
 *  may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/eclipse-1.0.php
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package org.mmtk.vm;

import org.vmutil.options.OptionSet;

/**
 * This class defines factory methods for VM-specific types which must
 * be instantiated within MMTk.  Since the concrete type is defined at
 * build time, we leave it to a concrete vm-specific instance of this class
 * to perform the object instantiation.
 */
public abstract class Factory {

  /**
   * Create or retrieve the OptionSet used for MMTk options.
   *
   * @return A concrete VM-specific OptionSet instance
   */
  public abstract OptionSet getOptionSet();

  /**
   * Create a new ActivePlan instance using the appropriate VM-specific
   * concrete ActivePlan sub-class.
   *
   * @see ActivePlan
   * @return A concrete VM-specific ActivePlan instance.
   */
  public abstract ActivePlan newActivePlan();

  /**
   * Create a new Assert instance using the appropriate VM-specific
   * concrete Assert sub-class.
   *
   * @see Assert
   * @return A concrete VM-specific Assert instance.
   */
  public abstract Assert newAssert();

  /**
   * Create a new Barriers instance using the appropriate VM-specific
   * concrete Barriers sub-class.
   *
   * @see Barriers
   * @return A concrete VM-specific Barriers instance.
   */
  public abstract Barriers newBarriers();

  /**
   * Create a new Collection instance using the appropriate VM-specific
   * concrete Collection sub-class.
   *
   * @see Collection
   * @return A concrete VM-specific Collection instance.
   */
  public abstract Collection newCollection();

  /**
   * Create a new BuildTimeConfig instance using the appropriate VM-specific
   * concrete BuildTimeConfig sub-class.
   *
   * @see Collection
   * @return A concrete VM-specific Collection instance.
   */
  public abstract BuildTimeConfig newBuildTimeConfig();

  /**
   * Create a new Lock instance using the appropriate VM-specific
   * concrete Lock sub-class.
   *
   * @see Lock
   * @param name The string to be associated with this lock instance
   * @return A concrete VM-specific Lock instance.
   */
  public abstract Lock newLock(String name);

  /**
   * Create a new Monitor instance using the appropriate VM-specific
   * concrete Lock sub-class.
   *
   * @see Monitor
   * @param name The string to be associated with this monitor instance
   * @return A concrete VM-specific Monitor instance.
   */
  public abstract Monitor newMonitor(String name);

  /**
   * Create a new Memory instance using the appropriate VM-specific
   * concrete Memory sub-class.
   *
   * @see Memory
   * @return A concrete VM-specific Memory instance.
   */
  public abstract Memory newMemory();

  /**
   * Create a new ObjectModel instance using the appropriate VM-specific
   * concrete ObjectModel sub-class.
   *
   * @see ObjectModel
   * @return A concrete VM-specific ObjectModel instance.
   */
  public abstract ObjectModel newObjectModel();

  /**
   * Create a new ReferenceProcessor instance using the appropriate VM-specific
   * concrete ReferenceProcessor sub-class.
   *
   * @see ReferenceProcessor
   * @return A concrete VM-specific ReferenceProcessor instance.
   */
  public abstract ReferenceProcessor newReferenceProcessor(int semantics);


  /**
   * Create a new FinalizbleProcessor instance using the appropriate VM-specific
   * concrete FinalizableProcessor sub-class.
   *
   * @see FinalizableProcessor
   * @return A concrete VM-specific FinalizableProcessor instance.
   */
  public abstract FinalizableProcessor newFinalizableProcessor();

  /**
   * Create a new Scanning instance using the appropriate VM-specific
   * concrete Scanning sub-class.
   *
   * @see Scanning
   * @return A concrete VM-specific Scanning instance.
   */
  public abstract Scanning newScanning();

  /**
   * Create a new Statistics instance using the appropriate VM-specific
   * concrete Statistics sub-class.
   *
   * @see Statistics
   * @return A concrete VM-specific Statistics instance.
   */
  public abstract Statistics newStatistics();

  /**
   * Create a new Strings instance using the appropriate VM-specific
   * concrete Strings sub-class.
   *
   * @see Strings
   * @return A concrete VM-specific Strings instance.
   */
  public abstract Strings newStrings();

  /**
   * Create a new SynchronizedCounter instance using the appropriate
   * VM-specific concrete SynchronizedCounter sub-class.
   *
   * @see SynchronizedCounter
   *
   * @return A concrete VM-specific SynchronizedCounter instance.
   */
  public abstract SynchronizedCounter newSynchronizedCounter();

  /**
   * Create a new TraceInterface instance using the appropriate VM-specific
   * concrete TraceInterface sub-class.
   *
   * @see TraceInterface
   * @return A concrete VM-specific TraceInterface instance.
   */
  public abstract TraceInterface newTraceInterface();

  /**
   * Create a new MMTk_Events instance using the appropriate VM-specific
   * concrete MMTk_Events sub-class.
   */
  public abstract MMTk_Events newEvents();

  /**
   * Create a new debug object
   */
  public abstract Debug newDebug();
}
